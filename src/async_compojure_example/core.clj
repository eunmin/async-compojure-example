(ns async-compojure-example.core
  (:gen-class)
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [compojure.core :refer :all]
            [compojure.response :refer [Sendable render]]
            [clojure.core.async :refer [go chan <! put!]]))

(extend-type clojure.core.async.impl.channels.ManyToManyChannel
  Sendable
  (send* [x request respond raise]
    (go
      (respond (render (<! x) request)))))

(defn hello-world []
  (let [ch (chan)]
    (future
      (put! ch "Hello World"))
    ch))

(defroutes app
  (GET "/" []
       (hello-world)))

(defn -main [& args]
  (run-jetty app {:port 3000 :async? true}))
