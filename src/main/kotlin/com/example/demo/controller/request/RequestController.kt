package com.example.demo.controller.request

import com.example.demo.model.Request
import com.example.demo.service.RequestService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("request")
class RequestController constructor(
    @Autowired
    private val requestService: RequestService
) {
    @PostMapping("/add")
    fun addRequest(@RequestBody request: Request) {
        requestService.addRequest(request)
    }

    @DeleteMapping("/{id}")
    fun deleteProducts(@PathVariable(value = "id") id: Int) {
        requestService.deleteRequest(id)
    }

    @PostMapping("/edit")
    fun editProducts(@RequestBody request: Request) {
        requestService.editRequest(request)
    }

    @GetMapping("/all")
    fun getAllProducts() {
        requestService.getAllRequest()
    }

}