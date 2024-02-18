(ns sicp.chapter-2.packages.op-table
  (:refer-clojure :exclude [get])
  (:require
    [clojure.pprint :as pp]))

(comment "Custom helper functions. Made myself, just for testing ---------------------------------")

(def operation-table (atom {}))

(defn attach-tag
  [tag value]
  {:tag tag, :contents value})

(defn put
  [operation types procedure]
  (swap! operation-table assoc-in [operation types] procedure))

(defn get
  [operation types]
  (get-in @operation-table [operation types]))

(defn apply-generic
  [op & args]
  (let [type-tags (map #(-> % :tag) args)
        operation (get op type-tags)]
    (if operation
      (apply operation (map #(:contents %) args))
      (throw (IllegalArgumentException. (str "No method for: " op))))))

(defn inspect
  []
  (->> @operation-table
       (map (fn [item]
              {:operation (first item)
               :types     (first (first (into '() (second item))))}))
       (pp/print-table)))
