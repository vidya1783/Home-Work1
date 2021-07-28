<template>
<div>
    <h1>MyBooks</h1>
    <reading-list />
    <nav>
      <router-link v-bind:to="{name: 'new-book'}">Add Book to Reading List</router-link>
  </nav>
    
    </div>
    
</template>

<script>

import ReadingList from '../components/ReadingList.vue';

export default {
    components:{
            ReadingList

        }
}
</script>
