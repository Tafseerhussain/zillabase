<template>
  <q-table
    :rows="rows"
    :columns="columns"
    row-key="name"
    flat
    :rows-per-page-options="[0]"
    hideBottom
    class="editable-table"
  >
    <template v-slot:body="props">
      <q-tr :props="props" :class="{ 'row-primary': props.row.primary }">
        <q-td v-for="col in columns" :key="col.name" :props="props">
          <template v-if="col.name === 'name'">
            <div class="flex items-center">
              <q-icon
                name="img:/icons/arrow-swap.svg"
                size="sm"
                class="filter-custom-dark q-mr-sm"
              />
              <q-input
                v-model="props.row.name"
                outlined
                dense
                placeholder="Enter name"
                class="flex-grow"
              />
            </div>
          </template>

          <template v-else-if="col.name === 'type'">
            <q-select
              v-model="props.row.type"
              :options="typeOptions"
              outlined
              dense
              placeholder="Select type"
              dropdown-icon="keyboard_arrow_down"
              style="min-width: 180px"
              :multiple="isMultiSelect"
            />
          </template>

          <template v-else-if="col.name === 'defaultValue'">
            <q-input
              v-model="props.row.defaultValue"
              outlined
              dense
              placeholder="Default value"
            />
          </template>

          <template v-else-if="col.name === 'primary'">
            <q-checkbox v-model="props.row.primary" dense color="light-green" />
          </template>
          <template v-else-if="col.name === 'isNullable'">
            <q-checkbox
              v-model="props.row.isNullable"
              dense
              color="light-green"
            />
          </template>

          <template v-else-if="col.name === 'actions'">
            <!-- Show action buttons for all rows except the last one -->
            <q-btn
              v-if="isSettingShow"
              icon="img:/icons/setting-2.svg"
              flat
              dense
              class="filter-custom-dark"
              @click="onSettingsClick(props.row)"
            />
            <q-btn
              v-if="props.row !== rows[rows.length - 1]"
              icon="img:/icons/close-square.svg"
              flat
              dense
              class="q-ml-sm"
              @click="removeRow(props.row)"
            />
            <q-btn
              v-if="props.row === rows[rows.length - 1]"
              unelevated
              icon="add"
              color="light-green"
              @click="addRow"
              style="width: 28px; min-height: 28px"
              class="rounded-10 q-pa-none text-custom-dark-color q-ml-sm"
            />
          </template>
        </q-td>
      </q-tr>
    </template>
  </q-table>
</template>

<script>
import { ref, defineComponent } from "vue";

export default defineComponent({
  name: "DataTypeTable",
  props: {
    columns: {
      type: Array,
      required: true,
    },
    rows: {
      type: Array,
      required: true,
    },
    typeOptions: {
      type: Array,
      required: true,
    },
    isSettingShow: {
      type: Boolean,
      required: false,
      default: true,
    },
    isMultiSelect: {
      type: Boolean,
      default: false,
    },
  },
  methods: {
    addRow() {
      this.$emit("add-row");
    },
    removeRow(row) {
      this.$emit("remove-row", row);
    },
    onSettingsClick(row) {
      this.$emit("setting-row", row);
    },
  },
});
</script>
<style lang="scss" scope>
.flex-grow {
  flex-grow: 1;
}
</style>
