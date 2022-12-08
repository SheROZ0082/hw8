package com.example.hw8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hw8.databinding.FragmentDetailsBinding
import com.example.hw8.databinding.FragmentListBinding

class Fragmentlist : Fragment() {
    lateinit var binding: FragmentListBinding
    private val a= arrayListOf<ChatModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        a.add(
            ChatModel(
                "poco x3 pro", "Диагональ экрана 6.67 Разрешение экрана 2400 x 1080 FHD+" +
                        "Камера Фронтальная камера 16 Мп Основная камера 108 Мп Фотовспышка Да Частота кадров видеосъемки 30 fps. Разрешение видеосъемки (пикс) 720p, 1080p.\n" +
                        "Электропитание Разъем для зарядки Емкость аккумулятора 5000 mA-ч Быстрая зарядка Да")
        )
        a.add(
            ChatModel(
                "realme c33","Система Платформа Android. Операционная система Android 12." +
                        "Память Объем встроенной памяти 128 Гб Объем оперативной памяти 4 Гб Слот для карты памяти Да Тип карты памяти"
        )

        )
        a.add(
            ChatModel(
                "IPhone XS","Поддержка HDR." + "2436×1125 пикселей, 458 пикселей на дюйм" + "Контрастность 1 000 000:1 (стандартная)"
        )
        )
        val adapter= ChatAdapter(a){
                findNavController().navigate(R.id.action_Fragmentlist_to_FragmentDetails, Bundle().apply {
                    putSerializable("key",a[it])
                })
        }
        binding.chatsRv.adapter=adapter



    }
}