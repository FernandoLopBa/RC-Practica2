(ns sockets.server
  (:import
   (java.io DataOutputStream BufferedReader InputStreamReader)
   (java.net ServerSocket)))

(defn start [puerto]
  (try
    (let [s          (ServerSocket. puerto)
          _          (println "Esperando... ")
          conn       (.accept s)
          _          (println "Cliente en línea")
          s-resp     (DataOutputStream. (.getOutputStream conn))
          _          (.writeUTF s-resp "Petición recibida y aceptada")
          entrada    (BufferedReader. (InputStreamReader. (.getInputStream conn)))
          msj-server (atom nil)]

      (while (some? (reset! msj-server (.readLine entrada)))
        (println @msj-server))

      (println "Fin de la comunicación")
      (.close s))

    (catch Exception e
      (prn e))))


#_(let [s   (Socket. "www.columbia.edu" 80)
        wtr (PrintWriter. (.getOutputStream s))]
    (.println wtr "GET /~fdc/sample.html HTTP/1.1")
    (.println wtr "Host: www.columbia.edu")
    (.println wtr "")
    (.flush wtr)
    ;;
    (let [rdr (-> s
                  (.getInputStream)
                  (InputStreamReader.)
                  (BufferedReader.))
          a   (atom nil)]

      (while (some? (reset! a (.readLine rdr)))
        (println @a)))
    )
