(defproject one "2.0.0-SNAPSHOT"
  :description "Getting Started with ClojureScript."
  :url "http://clojurescriptone.com"

  :dependencies [[org.clojure/clojure "1.7.0-alpha2"]
                 [org.clojure/clojurescript "0.0-2356"]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                 [om "0.7.3"]
                 [kioo "0.4.0"]]

  :profiles {:shared {:cljsbuild {:builds {:one {:source-paths ["src"]}}}}

             :dev [:shared
                   {:source-paths ["dev/clj"]
                    :dependencies [[enlive "1.1.5"]
                                   [figwheel "0.1.5-SNAPSHOT"]]
                    :plugins [[lein-marginalia "0.8.0"]
                              [lein-figwheel "0.1.5-SNAPSHOT"]]
                    :cljsbuild {:builds {:one {:compiler {:output-to "resources/public/js/one.js"
                                                          :output-dir "resources/public/js/out"
                                                          :optimizations :none
                                                          :source-map true}}}}
                    :figwheel {:http-server-root "public"
                               :server-port 3449
                               :css-dirs ["resources/public/css"]}}]}

  :plugins [[lein-cljsbuild "1.0.3"]]

  :source-paths ["src"])


