package au.com.qut



import org.junit.*
import grails.test.mixin.*

@TestFor(NovoControlValueController)
@Mock(NovoControlValue)
class NovoControlValueControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
		params["bundleName"] = 'Testing'
		params["valueName"] = 'Testing'
		params["value"] = 'Testing all'
    }

    void testIndex() {
        controller.index()
        assert "/novoControlValue/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.novoControlValueInstanceList.size() == 0
        assert model.novoControlValueInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.novoControlValueInstance != null
    }

    void testSave() {
        controller.save()

        assert model.novoControlValueInstance != null
        assert view == '/novoControlValue/create'

        response.reset()

        populateValidParams(params)
        controller.save()

		println 'URL ' + response.redirectedUrl
        assert response.redirectedUrl == '/novoControlValue/show/1'
        assert controller.flash.message != null
        assert NovoControlValue.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/novoControlValue/list'

        populateValidParams(params)
        def novoControlValue = new NovoControlValue(params)

        assert novoControlValue.save() != null

        params.id = novoControlValue.id

        def model = controller.show()

        assert model.novoControlValueInstance == novoControlValue
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/novoControlValue/list'

        populateValidParams(params)
        def novoControlValue = new NovoControlValue(params)

        assert novoControlValue.save() != null

        params.id = novoControlValue.id

        def model = controller.edit()

        assert model.novoControlValueInstance == novoControlValue
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/novoControlValue/list'

        response.reset()

        populateValidParams(params)
        def novoControlValue = new NovoControlValue(params)

        assert novoControlValue.save() != null

        // test invalid parameters in update
        params.id = novoControlValue.getPK()
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/novoControlValue/edit"
        assert model.novoControlValueInstance != null

        novoControlValue.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/novoControlValue/show/$novoControlValue.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        novoControlValue.clearErrors()

        populateValidParams(params)
        params.id = novoControlValue.id
        params.version = -1
        controller.update()

        assert view == "/novoControlValue/edit"
        assert model.novoControlValueInstance != null
        assert model.novoControlValueInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/novoControlValue/list'

        response.reset()

        populateValidParams(params)
        def novoControlValue = new NovoControlValue(params)

        assert novoControlValue.save() != null
        assert NovoControlValue.count() == 1

        params.id = novoControlValue.id

        controller.delete()

        assert NovoControlValue.count() == 0
        assert NovoControlValue.get(novoControlValue.id) == null
        assert response.redirectedUrl == '/novoControlValue/list'
    }
}
