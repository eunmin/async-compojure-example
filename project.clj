(defproject async-compojure-example "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/core.async "0.3.443"]
                 [ring "1.6.1"]
                 [compojure "1.6.0"]]
  :main async-compojure-example.core
  :profiles {:uberjar {:aot :all}})
