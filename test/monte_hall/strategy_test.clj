(ns monte-hall.strategy-test
  (:require [clojure.test :refer :all]
            [monte-hall.strategy :as strat]))

(deftest strategy-test
  (testing "retain door strategy"
    (is (= 0 (strat/choose-final-door strat/retain-door 0 2))))
  (testing "change door strategy"
    (is (= 1 (strat/choose-final-door strat/change-door 0 2)))))
