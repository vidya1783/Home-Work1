<template>
<div>
    <h1>{{product.name}}</h1>
    <p>{{procucts.description}}</p>
    <div class="actions">
        <router-link :to="{name: 'products'}">Back to Product List</router-link>
    <a href="#">Products List</a>
        <a href="#">Add Review</a></div>
        <div class="well-display">
            <average-summary/>
            <star-summary rating="1"></star-summary>
            <star-summary rating="2"></star-summary>
            <star-summary rating="3"></star-summary>
            <star-summary rating="4"></star-summary>
            <star-summary rating="5"></star-summary>

        </div>
        <review-list/>
</div>
    
</template>

<script>
import AverageSummary from '../components/AverageSummary.vue';
import StarSummary from '../components/StarSummary.vue';
import ReviewList from '../components/ReviewList.vue';



export default {
     name: "product-detail",
  created() {

    const activeProductID = this.$route.params.id;
     this.store.commit("SET_ACTIVE_PRODUCT", activeProductID);
  },
  computed: {
      product() {
          return this.$store.state.products.find(
          p => p.id == this.$store.state.activeProduct);
      }
  }

}
</script>

<style>

</style>