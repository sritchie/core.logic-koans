(defproject core.logic-koans "0.1.0-SNAPSHOT"
  :description "Walk this mountain to gain logical enlightenment"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/core.logic "0.8.3"]
                 [koan-engine "0.2.0"]]
  :plugins [[lein-koan "0.1.2"]]
  :main koan-engine.runner/exec)
