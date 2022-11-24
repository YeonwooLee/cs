# Activity-lifecycle

onCreate() - 액티비티 처음 실행

onPause() - 백그라운드로 밀렸을 때

onDestroy() - 어떠한 이유로 액티비티가 종료



앱이 실행되는 도중에도 여러 이유로 액티비티가 파괴되고 재생성 되는 경우가 생김

그럴 경우 액티비티는 가지고 있던 데이터를 모두 잃어버리고 onCreate부터 작업을 다시 수행해야 함

![image-20221002153528849](C:\Users\yeonw\AppData\Roaming\Typora\typora-user-images\image-20221002153528849.png)



가령 화면 돌리기만 해도 액티비티는 부숴졌다가 다시 생성됨

그래서 아래와같은 프로그램은 화면 도리면 textView가 다시 100으로 바뀜

```kotlin
package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding : ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var counter = 100
        binding.textView.text = counter.toString()

        binding.button.setOnClickListener {
            counter ++
            binding.textView.text = counter.toString()
        }
    }
}

```



그래서 나온게 onSveInstanceState

``` protexted void onSveInstanceState(Bundle onState)```

근데 문제가 onSveInstanceState가 다루는 번들이라는 형식이 대용량 데이터를 위한 자료구조가 아니었음(구글에서 onSveInstanceState가 다루는 번들의 크기를 50k로 제한)

그리고 번들은 serialization(?)에 사용도 불가하였음



그래서 나온게 viewmodel

- 액티비티와 독립된 생명주기
- finishㅔㅇ의해 activity가 파괴되고 재생성되더라도 viwmodel은 살아있다

![image-20221002162546547](C:\Users\yeonw\AppData\Roaming\Typora\typora-user-images\image-20221002162546547.png)

- 액티비티는 자기가 데이터를 갖지 말고 viwmodel의 데이터를 가져오는 방식으로 안정적으로 살알있을 수 있다.

```
implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1"
```





---

# navigation component

The Navigation component consists of three key parts that are described below:

- Navigation graph: An XML resource that contains all navigation-related information in one centralized location. This includes all of the individual content areas within your app, called *destinations*, as well as the possible paths that a user can take through your app.
- `NavHost`: An empty container that displays destinations from your navigation graph. The Navigation component contains a default `NavHost` implementation, [`NavHostFragment`](https://developer.android.com/reference/androidx/navigation/fragment/NavHostFragment), that displays fragment destinations.
- `NavController`: An object that manages app navigation within a `NavHost`. The `NavController` orchestrates the swapping of destination content in the `NavHost` as users move throughout your app.

As you navigate through your app, you tell the `NavController` that you want to navigate either along a specific path in your navigation graph or directly to a specific destination. The `NavController` then shows the appropriate destination in the `NavHost`.

The Navigation component provides a number of other benefits, including the following:

- Handling fragment transactions.
- Handling Up and Back actions correctly by default.
- Providing standardized resources for animations and transitions.
- Implementing and handling deep linking.
- Including Navigation UI patterns, such as navigation drawers and bottom navigation, with minimal additional work.
- [Safe Args](https://developer.android.com/guide/navigation/navigation-pass-data#Safe-args) - a Gradle plugin that provides type safety when navigating and passing data between destinations.
- `ViewModel` support - you can scope a `ViewModel` to a navigation graph to share UI-related data between the graph's destinations.

In addition, you can use Android Studio's [Navigation Editor](https://developer.android.com/guide/navigation/navigation-getting-started) to view and edit your navigation graphs.

---

# ViewModel



## 공유 ViewModel 사용 방법

## StartFragment를 업데이트하여 뷰 모델 사용

`StartFragment(가칭)`에서 공유 뷰 모델을 사용하려면 `viewModels()` 대리자 클래스 대신 `activityViewModels()`를 사용하여 `OrderViewModel(가칭)`을 초기화합니다.

- `viewModels()`는 현재 프래그먼트로 범위가 지정된 `ViewModel` 인스턴스를 제공합니다. 따라서 인스턴스는 프래그먼트마다 다릅니다.
- `activityViewModels()`는 현재 활동으로 범위가 지정된 `ViewModel` 인스턴스를 제공합니다. 따라서 인스턴스는 동일한 활동의 여러 프래그먼트 간에 동일하게 유지됩니다.
