import au.com.qut.NovoControlValue

class BootStrap {

	def init = { servletContext ->

		if (!NovoControlValue.count()){
			new NovoControlValue(bundleName: 'TestData1', valueName: 'TestValue1', value: 'value1').save(failOnError: true)
			new NovoControlValue(bundleName: 'TestData2', valueName: 'TestValue2', value: 'value2').save(failOnError: true)
			new NovoControlValue(bundleName: 'TestData3', valueName: 'TestValue3', value: 'value3').save(failOnError: true)
		}
	}
	def destroy = {
	}
}
