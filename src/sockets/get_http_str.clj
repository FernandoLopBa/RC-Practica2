(ns sockets.get-http-str
  (:import (java.net URL MalformedURLException)
           (java.util Date)))

(defn get-http-string [path]
  (try
    (let [url (URL. path)
          date (Date.)]
      (str (format "GET %s HTTP/1.1\n" (.getPath url))
           (format "Host: %s\n" (.getHost url))
           "Accept: /\n"
           "Connection: close\n"
           "User-Agent: Wget/1.16\n"
           "Cache-Control: no-cache\n"
           (format "Date: %s\n" (.toString date))))
    (catch MalformedURLException e (println "Malformed URL: "
                                            (.getMessage e)) (System/exit 0))))