(ns sicp.chapter-2.part-3.ex-2-69
  (:require [sicp.chapter-2.part-3.book-2-3 :as b23]))

; Exercise 2.69
;
; The following procedure takes as its argument a list of symbol-frequency pairs
; (where no symbol appears in more than one pair) and generates a Huffman encoding tree according
; to the Huffman algorithm.
;
; (define (generate-huffman-tree pairs)
;   (successive-merge
;    (make-leaf-set pairs)))
;
; Make-leaf-set is the procedure given above that transforms the list of pairs into an ordered set
; of leaves. Successive-merge is the procedure you must write, using make-code-tree to successively
; merge the smallest-weight elements of the set until there is only one element left, which is the
; desired Huffman tree.
;
; (This procedure is slightly tricky, but not really complicated. If you find yourself designing
; a complex procedure, then you are almost certainly doing something wrong.)
;
; You can take significant advantage of the fact that we are using an ordered set representation.)


(defn successive-merge [leaf-set]
  (if (= (count leaf-set) 1)
    (first leaf-set)
    (let [first  (first leaf-set)
          second (second leaf-set)
          rest   (drop 2 leaf-set)]
      (successive-merge (b23/adjoin-set-h
                          (b23/make-code-tree first second)
                          rest)))))

(defn generate-huffman-tree [pairs]
  (successive-merge (b23/make-leaf-set pairs)))
