<template>

    <v-data-table
        :headers="headers"
        :items="viewOrder"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'ViewOrderView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            viewOrder : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/viewOrders'))

            temp.data._embedded.viewOrders.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.viewOrder = temp.data._embedded.viewOrders;
        },
        methods: {
        }
    }
</script>

