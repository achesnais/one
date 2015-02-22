(ns one.main
  "Functions for starting and stopping the application. Instead of
  having a global entry point, create a start function which can be
  called externally. This allows you to define multiple entry points.
  It is also a good place to pass in configuration data which were
  sent with the initial page load."
  (:require [one.app :as app]
            [one.components.main :as main-component]
            [figwheel.client :as fw :include-macros true]))

;; Define the initial state of the application. This will be used to
;; initialize the application cursor. In this application we are only
;; using the cursor to hold state which determines what should be
;; displayed on the screen. We will not put domain data in the global
;; cursor.
(def initial-state {:view main-component/initial-view})

;; The `start` function does not do much at the moment but as the
;; application gets larger this is where we will create the major
;; components of the system and wire them together.
(defn start
  "Given a dom-id where the application will mount, create, initialize
  and wire together application components and start the app."
  [dom-id]
  ;; do not allow the app-state atom to be globally accessable
  (let [app-state (atom initial-state)]
    (app/create-ui dom-id app-state {})))

;; `start-dev` is the development entry point to the application. It
;; configures the client side dev environment and then starts the
;; applicaiton. Use `^:export` metadata to prevent this function name
;; from being munged during advanced compilation.
(defn ^:export start-dev [dom-id]
  ;; Enable the use of ClojureScript print functions for printing to the
  ;; console. This will handle printing Clojure data structures in a
  ;; readable form.
  (enable-console-print!)

  ;; Setup live reloading with figwheel
  (fw/watch-and-reload
   :jsload-callback #(print "reloaded"))

  (start dom-id))

;; `start-prod` is the production entry point for the application. Use
;; `^:export` metadata to prevent this function name from being munged
;; during advanced compilation.
(defn ^:export start-prod [dom-id]
  (start dom-id))
