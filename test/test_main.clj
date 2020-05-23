(ns test-main
  (:require [clojure.test]
            [l99-test]))

(defn -main [& _]
  (clojure.test/run-tests 'l99-test))
