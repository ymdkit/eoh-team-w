package com.example.team.w.fragments

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.team.w.R
import com.example.team.w.adapters.ProjectAdapter
import com.example.team.w.databinding.MainFragmentBinding
import com.example.team.w.extensions.setOrientation
import com.example.team.w.models.Project

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding =
            DataBindingUtil.inflate<MainFragmentBinding>(inflater, R.layout.main_fragment, container, false)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        val adapter = ProjectAdapter()
        adapter.projects = arrayListOf(
            Project(name = "プロジェクト1"),
            Project(name = "プロジェクト2")
        )
        adapter.setOnClickListener(object: ProjectAdapter.OnClickListener{

            override fun onClickPlayProject() {
                Toast.makeText(requireContext(),"play",Toast.LENGTH_SHORT).show()
            }

            override fun onClickEditProject() {
                Toast.makeText(requireContext(),"edit",Toast.LENGTH_SHORT).show()
            }

            override fun onClickDeleteProject() {
                Toast.makeText(requireContext(),"delete",Toast.LENGTH_SHORT).show()
            }

            override fun onClickAddProject() {
                adapter.projects.add(Project(name = "追加されたプロジェクト"))
                adapter.notifyDataSetChanged()
            }


        })

        binding.listProject.layoutManager = LinearLayoutManager(requireContext())
        binding.listProject.setHasFixedSize(true)
        binding.listProject.setOrientation(LinearLayoutManager.HORIZONTAL)
        binding.listProject.adapter = adapter


        return binding.root
    }

}
