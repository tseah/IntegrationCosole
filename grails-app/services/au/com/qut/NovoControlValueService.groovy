package au.com.qut

class NovoControlValueService {

	def showNovoControlValue(String p_bundleName, String p_valueName) {
		NovoControlValue.createCriteria().get{
			eq('bundleName',p_bundleName)
			eq('valueName',p_valueName)
		}

		//		def c = b.createCriteria()
		//		def results = c {
		//		  projections {
		//			groupProperty("a")
		//			count("a"), 'myCount' //Implicit alias is created here !
		//		    countDistinct 'id', 'myCount'
		//		  }
		//		  order 'myCount'
		//		}
	}
}
