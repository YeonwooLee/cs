# Heap

### 정의

---



### 특징

---



### 구현

---



---

- 트리처럼 보여지지만, 보통은 선형으로 저장됩니다. (배열, 링크드리스트처럼)

-  [힙(Heap)](https://en.wikipedia.org/wiki/Heap_(data_structure))

-  [소개 (영상)](https://www.coursera.org/learn/data-structures/lecture/2OpTs/introduction)

-  [Naive한 구현들 (영상)](https://www.coursera.org/learn/data-structures/lecture/z3l9N/naive-implementations)

-  [이진 트리 (영상)](https://www.coursera.org/learn/data-structures/lecture/GRV2q/binary-trees)

-  [Tree Height Remark (video)](https://www.coursera.org/learn/data-structures/supplement/S5xxz/tree-height-remark)

-  [기본 연산들 (영상)](https://www.coursera.org/learn/data-structures/lecture/0g1dl/basic-operations)

-  [완전 이진 트리 (영상)](https://www.coursera.org/learn/data-structures/lecture/gl5Ni/complete-binary-trees)

-  [의사 코드(Pseudocode) (영상)](https://www.coursera.org/learn/data-structures/lecture/HxQo9/pseudocode)

-  [힙 정렬 - 시작하기 (영상)](https://youtu.be/odNJmw5TOEE?list=PLFDnELG9dpVxQCxuD-9BSy2E7BWY3t5Sm&t=3291)

-  [힙 정렬 (영상)](https://www.coursera.org/learn/data-structures/lecture/hSzMO/heap-sort)

-  [힙 만들기 (영상)](https://www.coursera.org/learn/data-structures/lecture/dwrOS/building-a-heap)

-  [MIT: 힙과 힙 정렬 (영상)](https://www.youtube.com/watch?v=B7hVxCmfPtM&index=4&list=PLUl4u3cNGP61Oq3tWYp6V_F-5jb5L2iHb)

-  [CS 61B Lecture 24: 우선순위 큐 (영상)](https://archive.org/details/ucberkeley_webcast_yIUFT6AKBGE)

-  [선형 시간에 힙 만들기 (max-heap)](https://www.youtube.com/watch?v=MiyLo8adrWw)

-  

  max-heap 구현하기:

  -  insert

  -  sift_up - `insert` 하려면 필요

  -  get_max - 최대 원소를 반환하되, 삭제는 하지 않는다.

  -  get_size() - 저장된 원소들의 개수를 반환

  -  is_empty() - 힙에 원소를 하나도 없는 지 반환

  -  extract_max - 최대 원소를 반환하고, 그걸 삭제한다.

  -  sift_down - `extract_max` 하려면 필요하다

  -  remove(x) - x번째 원소를 삭제

  -  heapify - 배열에 있는 원소들로 힙을 만든다. `heap_sort` 하려면 필요

  -  

    heap_sort() - 정렬되지 않은 배열을 받아서 정렬된 배열로 만든다. 추가 메모리 없이 제자리에서 max-heap을 사용한다.

    - 노트: min-heap을 사용하면 연산을 줄일 수 있지만, 공간이 두 배로 필요합니다. (제자리에서 못 하기 때문에)