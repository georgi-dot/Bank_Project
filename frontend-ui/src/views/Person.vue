<template>
<div>
  <b-table striped hover :items="content" :fields="fields"></b-table>
</div>
</template>

<script>
import PersonService from '../service/person-service'

export default {
  name: 'Person',
  data () {
    return {
      content: [{
        id: '',
        name: '',
        iban: '',
        money: ''

      }],
      fields: [
        { key: 'name', label: 'Име' },
        { key: 'iban', label: 'Айбан' },
        { key: 'money', label: 'Пари' },
        { key: 'id', label: 'Номер' }
      ]
    }
  },
  mounted () {
    PersonService.getAllPersons().then(
      response => {
        console.log(response)
        this.content = response.data
      },
      error => {
        this.content =
          (error.response && error.response.data) ||
          error.message ||
          error.toString()
      }
    )
  }
}
</script>
<style scoped>

</style>
