package au.com.qut

class NovoControlValue implements Serializable {

	String bundleName
	String valueName
	String value

	static constraints = {
		bundleName(blank: false)
		valueName(blank: false)
		value(blank: false)
	}

	static mapping = {
		version false
		table 'NOVO_CONTROL_VALUES'

		id composite :['bundleName', 'valueName']
		columns {
			bundleName column:'BUNDLE_NAME'
			valueName column:'VALUE_NAME'
			value column:'VALUE'
		}
	}
	
	def getPK(){
			["bundleName": bundleName, "valueName": valueName]
		}
	}
