(defproject one "2.0.0-SNAPSHOT"
  :description "Getting Started with ClojureScript."
  :url "http://clojurescriptone.com"

  :dependencies [[org.clojure/clojure "1.7.0-alpha2"]
                 [org.clojure/clojurescript "0.0-2356"]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                 [om "0.7.3"]]

  :plugins [[lein-cljsbuild "1.0.3"]]

  :source-paths ["src"])


