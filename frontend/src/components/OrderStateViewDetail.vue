<template>

    <v-card outlined>
        <v-card-title>
            OrderState # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Boolean label="Canceled" v-model="item.canceled" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'OrderStateViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/orderStates/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

