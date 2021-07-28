<template>
<div>
    <h1>Home</h1>
    <best-Seller-list />
    <new-releases-list />
    </div>
    
</template>

<script>

import BestSellerList from '../components/BestSellerList.vue';
import NewReleasesList from '../components/NewReleasesList.vue';

export default {
    components:{
            BestSellerList,
            NewReleasesList

        }
}
</script>