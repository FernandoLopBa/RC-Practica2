(ns sockets.client
  (:import
   (java.io DataOutputStream)
   (java.net Socket)))

(defn start [opts]
  (try
    (let [cs            (Socket. "8.8.8.8" 1234)
          msj-to-server (DataOutputStream. (.getOutputStream cs))]

      (doseq [i (range 2)]
        (.writeUTF msj-to-server
                   (str "Este es el mensaje número " i "\n")))
      (.close cs))
    (catch Exception e
      (println e))))




