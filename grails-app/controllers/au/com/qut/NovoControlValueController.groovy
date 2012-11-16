package au.com.qut

import grails.converters.JSON
import grails.converters.XML
import org.springframework.dao.DataIntegrityViolationException

class NovoControlValueController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	def scaffold = true
	
	def xmlList = {
		render NovoControlValue.list() as XML
	}
	
	def xmlShow = {
		render NovoControlValue.get(params.id) as XML
	}
	
	def customXmlList = {
		def list = NovoControlValue.list()
		render (contentType:"text/xml"){
			NovoControlValues{
				for (n in list){
					NovoControlValue(){
						"Bundle_Name"(n.bundleName)
						"Value_Name"(n.valueName)
						"Value"(n.value)
					}
				}
			}
		}
	}
		
	def jsonList = {
		render NovoControlValue.list() as JSON
	}
	
	def customJsonList = {
		
		HashMap jsonMap = new HashMap()
		jsonMap.NovoControlValues = NovoControlValue.list().collect { novoControlValue ->
			return [Bundle_Name: novoControlValue.bundleName, Value_Name: novoControlValue.valueName, Value: novoControlValue.value]
		}
		render jsonMap as JSON
	}

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [novoControlValueInstanceList: NovoControlValue.list(params), novoControlValueInstanceTotal: NovoControlValue.count()]
    }

    def create() {
        [novoControlValueInstance: new NovoControlValue(params)]
    }

    def save() {
        def novoControlValueInstance = new NovoControlValue(params)
        if (!novoControlValueInstance.save(flush: true)) {
            render(view: "create", model: [novoControlValueInstance: novoControlValueInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'novoControlValue.label', default: 'NovoControlValue'), novoControlValueInstance.id])
        redirect(action: "show", id: novoControlValueInstance.id)
    }

	def show() { 	

		println "show + " + params
		
		def novoControlValueInstance = NovoControlValue.get(params.bundleName, params.valueName)
		if (!novoControlValueInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'novoControlValue.label', default: 'NovoControlValue'), params])
			redirect(action: "list")
			return
		}

		[novoControlValueInstance: novoControlValueInstance]
	}
	
	

    def edit() {				
        def novoControlValueInstance = NovoControlValue.get(params.bundleName, params.valueName)
        if (!novoControlValueInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'novoControlValue.label', default: 'NovoControlValue'), params])
            redirect(action: "list")
            return
        }

        [novoControlValueInstance: novoControlValueInstance]
    }

	def update() {
        def novoControlValueInstance = NovoControlValue.get(params.bundleName, params.valueName)
        if (!novoControlValueInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'novoControlValue.label', default: 'NovoControlValue'), params])
            redirect(action: "list")
            return
        }
		
        novoControlValueInstance.properties = params
		
        if (!novoControlValueInstance.save(flush: true)) {
            render(view: "edit", model: [novoControlValueInstance: novoControlValueInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'novoControlValue.label', default: 'NovoControlValue'), novoControlValueInstance.properties])
        redirect(action: "show", params: [bundleName: params.bundleName, valueName: params.valueName])
    }

    def delete(Long id) {
        def novoControlValueInstance = NovoControlValue.get(params.bundleName, params.valueName)
        if (!novoControlValueInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'novoControlValue.label', default: 'NovoControlValue'), params])
            redirect(action: "list")
            return
        }

        try {
            novoControlValueInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'novoControlValue.label', default: 'NovoControlValue'), params])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'novoControlValue.label', default: 'NovoControlValue'), params])
            redirect(action: "show", params: [bundleName: params.bundleName, valueName: params.valueName])
        }
    }
}
