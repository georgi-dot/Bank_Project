import axios from 'axios'

const API_URL = 'http://localhost:8080/person'

class PeopleService {
  getAllPersons () {
    return axios.get(API_URL + '/all')
  }
}

export default new PeopleService()
