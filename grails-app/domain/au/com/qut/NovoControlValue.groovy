package au.com.qut

class NovoControlValue implements Serializable {

	String bundleName
	String valueName
	String value

	static constraints = {
		bundleName()
		valueName()
		value()
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

	static NovoControlValue get (String p_bundleName, String p_valueName){
		NovoControlValue.createCriteria().get{
			eq('bundleName',p_bundleName)
			eq('valueName',p_valueName)			
		}
	}
	
	def getPK(){
			["bundleName": bundleName, "valueName": valueName]
		}
	}
