{:shared {:cljsbuild {:builds {:one {:source-paths ["src"]}}}}

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
                   :css-dirs ["resources/public/css"]}}]

 ;; TODO: create prod profile
 }
