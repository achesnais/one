(defproject one "2.0.0-SNAPSHOT"
  :description "Getting Started with ClojureScript."
  :url "http://clojurescriptone.com"

  :dependencies [[org.clojure/clojure "1.7.0-alpha2"]
                 [org.clojure/clojurescript "0.0-2356"]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                 [om "0.7.3"]]

  :plugins [[lein-cljsbuild "1.0.3"]
            [lein-marginalia "0.8.0"]]

  :source-paths ["src"]

  :cljsbuild {:builds {:one-dev {:source-paths ["src"]
                                 :compiler {:output-to "one.js"
                                            :output-dir "out"
                                            :optimizations :none
                                            :source-map true}}}})
