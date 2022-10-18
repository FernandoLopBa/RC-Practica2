(ns sockets.writer-http
  (:require [sockets.get-http-str]
            [sockets.send-request]
            [clojure.java.io :as io]))

(defn file-writer [file-name content]
  (with-open [w (io/writer file-name)]
    (.write w (str content))))

(defn http-writer [url o-name]
  (file-writer o-name (sockets.send-request/send-request 
                    (sockets.get-http-str/get-http-str url))))
