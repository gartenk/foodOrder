<template>

    <v-card outlined>
        <v-card-title>
            Menu # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="Item" v-model="item.item" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'MenuViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/menus/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

