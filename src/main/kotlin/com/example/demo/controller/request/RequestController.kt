package com.example.demo.controller.request

import com.example.demo.model.Products
import com.example.demo.model.Request
import com.example.demo.model.dto.addRequestRequest.AddRequestRequest
import com.example.demo.model.dto.product.AddProductRequest
import com.example.demo.service.RequestService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path=["request"])
class RequestController constructor(
    @Autowired
    private val requestService: RequestService
) {
    @PostMapping("/add")
    fun addRequest(@RequestBody request: AddRequestRequest) {
        requestService.addRequest(Request(null,request.requestNumber, request.requestName, request.creationDate, request.customer, request.expectedDate, request.actualDate, null, request.status))
    }

    @DeleteMapping("/{id}")
    fun deleteRequest(@PathVariable(value = "id") id: Int) {
        requestService.deleteRequest(id)
    }

    @PutMapping("/{id}")
    fun editRequest(@PathVariable(value = "id") id: Int, @RequestBody request: Request): Request {
        request.id = id
        return requestService.editRequest(request)
    }

    @GetMapping("/all")
    fun getAllRequest(): List<Request>{
        return requestService.getAllRequest()
    }

}