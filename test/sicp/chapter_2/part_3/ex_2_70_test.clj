(ns sicp.chapter-2.part-3.ex-2-70-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-2.part-3.ex-2-68 :as ex-2-68]
    [sicp.chapter-2.part-3.ex-2-69 :as ex-2-69]
    [sicp.chapter-2.part-3.ex-2-70 :refer [abc song]]))

(deftest abc-test
  (is (= '[[:leaf :na 16]
           [[:leaf :yip 9]
            [[[:leaf :a 2]
              [[:leaf :Wah 1]
               [:leaf :boom 1]
               (:Wah :boom) 2]
              (:a :Wah :boom) 4]
             [[:leaf :Sha 3]
              [[:leaf :job 2]
               [:leaf :Get 2]
               (:job :Get) 4]
              (:Sha :job :Get) 7]
             (:a :Wah :boom :Sha :job :Get) 11]
            (:yip :a :Wah :boom :Sha :job :Get) 20]
           (:na :yip :a :Wah :boom :Sha :job :Get) 36]
         (ex-2-69/generate-huffman-tree abc))))

(deftest symbols-test
  (is (= '(0)
         (ex-2-68/encode-symbol :na (ex-2-69/generate-huffman-tree abc))))
  (is (= '(1 0)
         (ex-2-68/encode-symbol :yip (ex-2-69/generate-huffman-tree abc))))
  (is (= '(1 1 1 0)
         (ex-2-68/encode-symbol :Sha (ex-2-69/generate-huffman-tree abc))))
  (is (= '(1 1 0 0)
         (ex-2-68/encode-symbol :a (ex-2-69/generate-huffman-tree abc))))
  (is (= '(1 1 1 1 1)
         (ex-2-68/encode-symbol :Get (ex-2-69/generate-huffman-tree abc))))
  (is (= '(1 1 1 1 0)
         (ex-2-68/encode-symbol :job (ex-2-69/generate-huffman-tree abc))))
  (is (= '(1 1 0 1 0)
         (ex-2-68/encode-symbol :Wah (ex-2-69/generate-huffman-tree abc))))
  (is (= '(1 1 0 1 1)
         (ex-2-68/encode-symbol :boom (ex-2-69/generate-huffman-tree abc)))))

(deftest song-encode-test
  (is (= '(1 1 1 1 1 1 1 0 0 1 1 1 1 0 1 1 1
             0 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 0
             0 1 1 1 1 0 1 1 1 0 0 0 0 0 0 0 0
             0 1 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1
             0 1 0 1 0 1 0 1 1 1 0 1 1 0 1 1)
         (ex-2-68/encode song (ex-2-69/generate-huffman-tree abc))))
  ; (~11 bytes) 84 bits insted of 124 charates OR 992 bits!
  ; 992/84 = ~11.8 times smaller
  ; 1 - 84/992 = ~91.5% safe memory space (without tree)
  (is (= 84 (count (ex-2-68/encode song (ex-2-69/generate-huffman-tree abc)))))
  ; If we were to use a fixed-length encoding on that rock song
  ; We would need 3 bits (8 = 2^3) per symbol.
  ; PS. 8 is number of unique words in the tree
  (is (= 108 (* 3 (count song)))))
