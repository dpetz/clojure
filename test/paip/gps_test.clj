(ns paip.gps-test
    (:require [clojure.test :refer :all] [paip.gps :refer :all]))
 ;   (:import (paip.gps Op)))

(def A-to-B (make-op
    :A-to-B
    [:A]
    [:B]
    [:A]))

(def B-to-C (make-op
    :B-to-C
    [:B]
    [:C]
    [:B]))

(def ops "Set of available operations" [
    (make-op
        :drive-son-to-school
        [:son-at-home :car-works]
        [:son-at-school]
        [:son-at-home])
    (make-op
        :shop-installs-battery
        [:car-needs-battery :shop-knows-problem :shop-has-money]
        [:car-works]
        [])
    (make-op
        :just-do-it
        []
        [:drive-son-to-school]
        [])])


(deftest in-state []
    "If goal in state, solved w/o actions"
    (is (= [] (solve [:G] [:G] []))))


(deftest single-op []
    "Single action solving"
    (is (= [:A-to-B] (solve [:B] [:A] [A-to-B]))))

(deftest two-ops []
    "Two action solving"
    (is (= [:A-to-B :B-to-C] (solve [:C] [:A] [B-to-C A-to-B]))))

(deftest not-in-state []
    "If goal not in state, cannot be solved w/o actions" 
    (is (nil? (solve [:G] [:not-G] [A-to-B]))))
