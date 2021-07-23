<template>
  <div class="container">
    <table id="tblUsers">
      <thead>
        <tr>
          <th>&nbsp;</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Username</th>
          <th>Email Address</th>
          <th>Status</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>
            <input type="checkbox" id="selectAll" v-model="selectAll"/>
          </td>
          <td>
            <input type="text" id="firstNameFilter" v-model="filter.firstName" />
          </td>
          <td>
            <input type="text" id="lastNameFilter" v-model="filter.lastName" />
          </td>
          <td>
            <input type="text" id="usernameFilter" v-model="filter.username" />
          </td>
          <td>
            <input type="text" id="emailFilter" v-model="filter.emailAddress" />
          </td>
          <td>
            <select id="statusFilter" v-model="filter.status">
              <option value>Show All</option>
              <option value="Active">Active</option>
              <option value="Disabled">Disabled</option>
            </select>
          </td>
          <td>&nbsp;</td>
        </tr>
        <tr
          v-for="user in filteredList"
          v-bind:key="user.id"
          v-bind:class="{ disabled: user.status === 'Disabled' }"
        >
          <td>
            <input type="checkbox" v-bind:id="user.id" v-bind:value="user.id" @change="check($event, user.id)" v-model="selected" />
          </td>
          <td>{{ user.firstName }}</td>
          <td>{{ user.lastName }}</td>
          <td>{{ user.username }}</td>
          <td>{{ user.emailAddress }}</td>
          <td>{{ user.status }}</td>
          <td>
            <button class="btnEnableDisable" @click="flipStatus(user.id)">
              <span v-if="user.status == 'Disabled'">Enable</span>
              <span v-if="user.status == 'Active'">Disable</span>
            </button>
          </td>
        </tr>
      </tbody>
    </table>
    <div class="all-actions">
      <button :disabled="actionButtonDisabled" @click="enableSelectedUsers">Enable Users</button>
      <button :disabled="actionButtonDisabled" @click="disableSelectedUsers">Disable Users</button>
      <button :disabled="actionButtonDisabled" @click="deleteSelectedUsers">Delete Users</button>
    </div>
<!-- The toggleAddUser is just switching the variable from false to true, which will  in turn activate the form below -->
    <button v-on:click="toggleAddUser">Add New User</button>
<!-- So the saveUser function is basically pushing the model into the array of objects "users". That then populates the list  -->
    <form id="frmAddNewUser" v-show="showForm" v-on:submit.prevent="saveUser">
      <div class="field">
        <label for="firstName">First Name:</label>
        <input type="text" name="firstName" v-model="newUser.firstName"/>
      </div>
      <div class="field">
        <label for="lastName">Last Name:</label>
        <input type="text" name="lastName" v-model="newUser.lastName"/>
      </div>
      <div class="field">
        <label for="username">Username:</label>
        <input type="text" name="username" v-model="newUser.username"/>
      </div>
      <div class="field">
        <label for="emailAddress">Email Address:</label>
        <input type="text" name="emailAddress" v-model="newUser.emailAddress"/>
      </div>
      <button type="submit" class="btn save">Save User</button>
    </form>
  </div>
</template>
<script>
export default {
  name: "user-list",
  data() {
    return {
      showForm: false,
      selectedUserIDs: [],
      selected: [],
      filter: {
        firstName: "",
        lastName: "",
        username: "",
        emailAddress: "",
        status: ""
      },
      newUser: {
        id: null,
        firstName: "",
        lastName: "",
        username: "",
        emailAddress: "",
        status: "Active"
      },
      users: [
        {
          id: 1,
          firstName: "John",
          lastName: "Smith",
          username: "jsmith",
          emailAddress: "jsmith@gmail.com",
          status: "Active"
        },
        {
          id: 2,
          firstName: "Anna",
          lastName: "Bell",
          username: "abell",
          emailAddress: "abell@yahoo.com",
          status: "Active"
        },
        {
          id: 3,
          firstName: "George",
          lastName: "Best",
          username: "gbest",
          emailAddress: "gbest@gmail.com",
          status: "Disabled"
        },
        {
          id: 4,
          firstName: "Ben",
          lastName: "Carter",
          username: "bcarter",
          emailAddress: "bcarter@gmail.com",
          status: "Active"
        },
        {
          id: 5,
          firstName: "Katie",
          lastName: "Jackson",
          username: "kjackson",
          emailAddress: "kjackson@yahoo.com",
          status: "Active"
        },
        {
          id: 6,
          firstName: "Mark",
          lastName: "Smith",
          username: "msmith",
          emailAddress: "msmith@foo.com",
          status: "Disabled"
        }
      ]
    };
  },
  methods: {
    saveUser() {
      //has to create models per object property above in order to have data push correctly
      this.users.push({id: this.users.length + 1, firstName: this.newUser.firstName, lastName: this.newUser.lastName, 
      username: this.newUser.username, emailAddress: this.newUser.emailAddress, status: "Disabled"})
      this.newUser = {}
    },
    toggleAddUser() {
      this.showForm = !this.showForm;
    },
    flipStatus(id) {
      let userToChange = this.findUserById(id);
      if(userToChange.status == "Disabled") {
          userToChange.status = "Active";
        } else {
          userToChange.status = "Disabled";
        }
    },
    check(event, id) {
      if (event.target.checked) {
        this.selectedUserIDs.push(id)
      } else {
        this.selectedUserIDs = this.selectedUserIDs.filter((item) => {
          return item !== id;
        });
      }
    },
    enableSelectedUsers() {
      this.selectedUserIDs.forEach((id) => {
        let user = this.findUserById(id)
        user.status = "Active";
      });
    },
    disableSelectedUsers() {
      this.selectedUserIDs.forEach((id) => {
        let user = this.findUserById(id)
        user.status = "Disabled";
      });
    },
    deleteSelectedUsers() {
      this.users = this.users.filter((user) => {
        return !this.selectedUserIDs.includes(user.id)
      });
    },
    findUserById(id) {
      return this.users.find((user) => {
        return user.id === id;
      });
    }
  },
  computed: {
    filteredList() {
      let filteredUsers = this.users;
      if (this.filter.firstName != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.firstName
            .toLowerCase()
            .includes(this.filter.firstName.toLowerCase())
        );
      }
      if (this.filter.lastName != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.lastName
            .toLowerCase()
            .includes(this.filter.lastName.toLowerCase())
        );
      }
      if (this.filter.username != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.username
            .toLowerCase()
            .includes(this.filter.username.toLowerCase())
        );
      }
      if (this.filter.emailAddress != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.emailAddress
            .toLowerCase()
            .includes(this.filter.emailAddress.toLowerCase())
        );
      }
      if (this.filter.status != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.status === this.filter.status
        );
      }
      return filteredUsers;
    },
    actionButtonDisabled() {
      if (this.selectedUserIDs.length == 0) {
        return true;
      } else {
        return false;
      }
    },
    selectAll: {
      get: function () {
          return this.users ? this.selected.length == this.users.length : false;
      },
      set: function (value) {
        let selected = [];
        let selectedIDs = [];
        if (value) {
            this.users.forEach(function (user) {
                selected.push(user.id);
                selectedIDs.push(user.id);
            });
        }
        this.selectedUserIDs = selectedIDs;
        this.selected = selected;
      }
    }
  }
};
</script>
<style scoped>
table {
  margin-top: 20px;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
  margin-bottom: 20px;
}
th {
  text-transform: uppercase;
}
td {
  padding: 10px;
}
tr.disabled {
  color: red;
}
input,
select {
  font-size: 16px;
}
form {
  margin: 20px;
  width: 350px;
}
.field {
  padding: 10px 0px;
}
label {
  width: 140px;
  display: inline-block;
}
button {
  margin-right: 5px;
}
.all-actions {
  margin-bottom: 40px;
}
.btn.save {
  margin: 20px;
  float: right;
}
</style>
