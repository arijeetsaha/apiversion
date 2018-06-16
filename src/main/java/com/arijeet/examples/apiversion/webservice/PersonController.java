package com.arijeet.examples.apiversion.webservice;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arijeet.examples.apiversion.bean.Name;
import com.arijeet.examples.apiversion.bean.Person;
import com.arijeet.examples.apiversion.bean.PersonV2;

/**
 * Identifies various kinds of API versioning
 * 
 * @author arijeet
 *
 */
@RestController
@RequestMapping("/app")
public class PersonController {

	/**
	 * Original api with version - v1
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/v1/person/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Person getPerson(@PathVariable String id) {
		Person p = new Person(id, "Romeo Gonzalves", "Amsterdam, Netherlands");
		return p;
	}

	/**
	 * Versioning the api endpoint
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/v2/person/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonV2 getPersonV2(@PathVariable String id) {
		Name m = new Name("Romeo", "Gonzalves");
		PersonV2 p = new PersonV2(id, m, "Amsterdam, Netherlands");
		return p;
	}

	/**
	 * Versioning using Request Param
	 */
	@RequestMapping(value = "/person/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, params = "v=1")
	public Person getPersonV1RequestParam(@PathVariable String id) {
		Person p = new Person(id, "Romeo Gonzalves", "Amsterdam, Netherlands");
		return p;
	}

	/**
	 * Versioning using Request Param
	 */
	@RequestMapping(value = "/person/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, params = "v=2")
	public PersonV2 getPersonV2RequestParam(@PathVariable String id) {
		Name m = new Name("Romeo", "Gonzalves");
		PersonV2 p = new PersonV2(id, m, "Amsterdam, Netherlands");
		return p;
	}

	/**
	 * Versioning using Headers
	 */
	@RequestMapping(value = "/person/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, headers = "X-API-VERSION=v1")
	public Person getPersonV1Headers(@PathVariable String id) {
		Person p = new Person(id, "Romeo Gonzalves", "Amsterdam, Netherlands");
		return p;
	}

	/**
	 * Versioning using Headers
	 */
	@RequestMapping(value = "/person/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, headers = "X-API-VERSION=v2")
	public PersonV2 getPersonV2Headers(@PathVariable String id) {
		Name m = new Name("Romeo", "Gonzalves");
		PersonV2 p = new PersonV2(id, m, "Amsterdam, Netherlands");
		return p;
	}
	
	// MediaType Versioning
	
	/**
	 * Versioning using mediatype
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/person/{id}", method = RequestMethod.GET, produces = "application/app-v1+json")
	public Person getPersonV1MediaType(@PathVariable String id) {
		Person p = new Person(id, "Romeo Gonzalves", "Amsterdam, Netherlands");
		return p;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/person/{id}", method = RequestMethod.GET, produces = "application/app-v2+json")
	public PersonV2 getPersonV2MediaType(@PathVariable String id) {
		Name m = new Name("Romeo", "Gonzalves");
		PersonV2 p = new PersonV2(id, m, "Amsterdam, Netherlands");
		return p;
	}
}
