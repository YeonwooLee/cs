# ViewModel



## 공유 ViewModel 사용 방법

## StartFragment를 업데이트하여 뷰 모델 사용

`StartFragment(가칭)`에서 공유 뷰 모델을 사용하려면 `viewModels()` 대리자 클래스 대신 `activityViewModels()`를 사용하여 `OrderViewModel(가칭)`을 초기화합니다.

- `viewModels()`는 현재 프래그먼트로 범위가 지정된 `ViewModel` 인스턴스를 제공합니다. 따라서 인스턴스는 프래그먼트마다 다릅니다.
- `activityViewModels()`는 현재 활동으로 범위가 지정된 `ViewModel` 인스턴스를 제공합니다. 따라서 인스턴스는 동일한 활동의 여러 프래그먼트 간에 동일하게 유지됩니다.
