(ns sicp.chapter-2.part-3.ex-2-70)

; Exercise 2.70
;
; The following eight-symbol alphabet with associated relative frequencies was designed
; to efficiently encode the lyrics of 1950s rock songs. (Note that the “symbols” of an “alphabet”
; need not be individual letters.)
;
; A    2    NA  16
; BOOM 1    SHA  3
; GET  2    YIP  9
; JOB  2    WAH  1
;
; Use generate-huffman-tree (Exercise 2.69) to generate a corresponding Huffman tree, and use
; encode (Exercise 2.68) to encode the following message:
;
; Get a job
; Sha na na na na na na na na
;
; Get a job
; Sha na na na na na na na na
;
; Wah yip yip yip yip
; yip yip yip yip yip
; Sha boom
;
; How many bits are required for the encoding? What is the smallest number of bits that would be
; needed to encode this song if we used a fixed-length code for the eight-symbol alphabet?

(def abc '((:a 2) (:na 16)
           (:boom 1) (:Sha 3)
           (:Get 2) (:yip 9)
           (:job 2) (:Wah 1)))

(def song '(:Get :a :job
             :Sha :na :na :na :na :na :na :na :na
             :Get :a :job
             :Sha :na :na :na :na :na :na :na :na
             :Wah :yip :yip :yip :yip
             :yip :yip :yip :yip :yip
             :Sha :boom))
