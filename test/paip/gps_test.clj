(ns paip.gps-test
    (:require [clojure.test :refer :all]
        [paip.gps :refer :all]))

        (def ops "Set of available operations" (list
            (Op.
                :drive-son-to-school
                [:son-at-home :car-works]
                [:son-at-school]
                [:son-at-home])
            (Op.
                :shop-installs-battery
                [:car-needs-battery :shop-knows-problem :shop-has-money]
                [:car-works]
                [])
            (Op.
                :just-do-it
                []
                [:drive-son-to-school]
                [])))

(deftest achieve-single-op []
    "Unit test paip.gps/apply-op"
    (let [op (paip.gps.Op.
        :A-to-B
        #{ :A }
        #{ :B }
        #{ :A })]
        
        (is (achieve
            :B
            #{:A}
            #{op}))))

;(achieve-single-op)

(deftest achieve-in-state []
   "If goal is in state its achieved" 
    (is (achieve :G #{:G} #{})))

(deftest achieve-not-in-state []
    "If goal is in state its achieved" 
    (is (nil? (achieve :G #{:not-G} #{}))))
    

;(paip.gps-test/achieve-in-state)