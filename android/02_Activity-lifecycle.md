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

