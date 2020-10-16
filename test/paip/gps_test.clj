(ns paip.gps-test
    (:require [clojure.test :refer :all]
        [paip.gps :refer :all]))

(deftest achieved-single-åop []
    "Unit test paip.gps/apply-op"
    (let [op (paip.gps.Op.
        :A-to-B
        #{ :A }
        #{ :B }
        #{ :A })]
        
        (is (true? (achieved?
            :B
            #{:A}
            #{op})))))

;(achieved-single-op)

(deftest achieved-if-holds-test []
   "If goal is in state its achieved" 
    (is (true? (achieved? :G #{:G} #{}))))

;(achieved-if-holds-test)