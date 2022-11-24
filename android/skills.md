## 액티비티 하나에서 navigation을 이용해 fragment를 변경

#activity_main.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <androidx.fragment.app.FragmentContainerView
        android:id="@+id/nav_host_fragment"
        android:name="androidx.navigation.fragment.NavHostFragment"
        android:layout_width="0dp"
        android:layout_height="0dp"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintBottom_toBottomOf="parent"

        app:defaultNavHost="true"
        app:navGraph="@navigation/nav_graph" />

</androidx.constraintlayout.widget.ConstraintLayout>
```


#MainActivity.kt

```kotlin
package com.example.sharedviewmodelprac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        
        //상단바 이름 fragment name으로 바꿈
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        val navController = navHostFragment.navController

        setupActionBarWithNavController(navController)
    }
}
```

## 여러 프래그먼트가 공유된 하나의 viewModel을 사용하게 할 수 있음

#fragment_back.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
        <variable
            name="sharedVM"
            type="com.example.sharedviewmodelprac.model.SharedViewModel" />
        <variable
            name="backFragment"
            type="com.example.sharedviewmodelprac.BackFragment" />
    </data>

    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".BackFragment">


        <RadioGroup
            android:id="@+id/back_radio_group"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            app:layout_constraintTop_toTopOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintEnd_toEndOf="parent">

            <RadioButton
                android:id="@+id/set_three"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="@{sharedVM.backSetList[0].toString()}"
                android:onClick="@{()->sharedVM.setBackSet(sharedVM.backSetList[0])}"
                android:checked="@{sharedVM.backSet.equals(sharedVM.backSetList[0])}"
                tools:text="삼세트(tl" />

            <RadioButton
                android:id="@+id/set_five"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="@{sharedVM.backSetList[1].toString()}"
                android:onClick="@{()->sharedVM.setBackSet(sharedVM.backSetList[1])}"
                android:checked="@{sharedVM.backSet.equals(sharedVM.backSetList[1])}"
                tools:text="오세트" />

            <RadioButton
                android:id="@+id/set_seven"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="@{sharedVM.backSetList[2].toString()}"
                android:onClick="@{()->sharedVM.setBackSet(sharedVM.backSetList[2])}"
                android:checked="@{sharedVM.backSet.equals(sharedVM.backSetList[2])}"
                tools:text="칠세트" />
        </RadioGroup>

        <Button
            android:id="@+id/go_next"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="다음페이지로(시작)"
            android:onClick="@{()->backFragment.goNextScreen()}"
            app:layout_constraintTop_toBottomOf="@id/back_radio_group"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintEnd_toEndOf="parent" />

    </androidx.constraintlayout.widget.ConstraintLayout>
</layout>
```



#BackFragment.kt

```kotlin
package com.example.sharedviewmodelprac


import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.sharedviewmodelprac.databinding.FragmentBackBinding//데이터바인딩 클래스
import com.example.sharedviewmodelprac.model.SharedViewModel

class BackFragment : Fragment() {
    var binding:FragmentBackBinding?=null
    private val sharedViewModel:SharedViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentBackBinding.inflate(inflater,container,false)//바인딩하고 뷰 확장
        binding = fragmentBinding
        return fragmentBinding.root//최상단 뷰 리턴
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply{
//            goNext.setOnClickListener{goNextScreen()}//apply 덕분에 앞에 'binding?.' 생략됨
            sharedVM = sharedViewModel
            backFragment=this@BackFragment
        }
    }

    fun goNextScreen(){
        findNavController().navigate(R.id.action_backFragment_to_chestFragment)
    }

}
```

