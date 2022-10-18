(ns sockets.send-request
  (:require [clojure.string :as cs])
  (:import (java.net Socket
                     UnknownHostException
                     MalformedURLException
                     ConnectException)
           (java.io PrintWriter
                    BufferedReader
                    InputStreamReader
                    IOException)))

(defn send-request [http-request]
  (try
    (let [host (subs http-request
                     (+ (cs/index-of http-request "Host: ") (count "Host: "))
                     (cs/index-of http-request "\nAccept: "))
          s (Socket. host 80)
          wtr (PrintWriter. (.getOutputStream s))]
      (.println wtr http-request)
      (.println wtr "")
      (.flush wtr)

      (let [rdr (-> s
                    (.getInputStream)
                    (InputStreamReader.)
                    (BufferedReader.))
            res (atom "")
            a   (atom nil)]

        (while (some? (reset! a (.readLine rdr)))
          (reset! res (str @res "\n" @a)))
        (.close rdr)
        (.close wtr)
        (.close s)
        @res))
    (catch UnknownHostException e (str "Unknown Host: " (.getMessage e)))
    (catch IOException e (str "IO Error: " (.getMessage e)))
    (catch MalformedURLException e (str "Malformed URL: " (.getMessage e)))
    (catch ConnectException e (str "Connection error: " (.getMessage e)))))