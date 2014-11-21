(defproject one "2.0.0-SNAPSHOT"
  :description "Getting Started with ClojureScript."
  :url "http://clojurescriptone.com"

  :dependencies [[org.clojure/clojure "1.7.0-alpha2"]
                 [org.clojure/clojurescript "0.0-2356"]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                 [enlive "1.1.5"]
                 [om "0.7.3"]
                 ;; TODO put in dev profile
                 [figwheel "0.1.5-SNAPSHOT"]]

  :plugins [[lein-cljsbuild "1.0.3"]
            [lein-marginalia "0.8.0"]
            [lein-figwheel "0.1.5-SNAPSHOT"]]

  ;; TODO: put dev/clj in dev profile
  :source-paths ["src" "dev/clj"]

  :cljsbuild {:builds {:one-dev {:source-paths ["src"]
                                 :compiler {:output-to "resources/public/js/one.js"
                                            :output-dir "resources/public/js/out"
                                            :optimizations :none
                                            :source-map true}}}}

  :figwheel {:http-server-root "public"
             :server-port 3449
             :css-dirs ["resources/public/css"]})
