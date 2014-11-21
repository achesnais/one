(ns one.dom
  "This namespace provides the `build-om` macro which allows you to
  build up lots of Om dom nodes using a more consice syntax.")

(defn set-class-name [attrs-map]
  (if (:class attrs-map)
    (-> attrs-map
        (assoc :className (:class attrs-map))
        (dissoc :class))
    attrs-map))

(defn expand-attrs [attrs]
  (list 'clj->js
        (cond (string? attrs)
              {:className attrs}
              (map? attrs)
              (set-class-name attrs)
              :else attrs)))

(defn splice-val [vals]
  (when (and (coll? (first vals))
             (= (ffirst vals) 'splice))
    (last (first vals))))

(defn expand-node [node]
  (if (vector? node)
    (let [[type attrs & vals] node
          attrs (expand-attrs attrs)
          om-dom (symbol "om.dom" (name type))]
      (if-let [val (splice-val vals)]
        `(apply ~om-dom ~attrs ~val)
        `(~om-dom ~attrs ~@(map expand-node vals))))
    node))

(defmacro build-om
  "Given a root node in the concise syntax, recursively expand nodes
  into `om.dom` function calls. Each node is represented as a vector
  with two or more items. The first item is the name of a function in
  the `om.dom` namespace. The second item is the attributes map. This
  may also be a string which will be interpreted as the class
  attribute. If attributes are provided as a map, you may use `:class`
  instead of `:className`. Any additional items are child nodes. If
  children are vectors then they will be recursively processed.

  A special splice node can be used and will be transformed as shown
  below

  `[div {} [splice (something-that-evals-to-a-seq)]]`

  becomes

  `(apply dom/div #js {} (something that evals to a collection))`
  "
  [root-node]
  (expand-node root-node))
