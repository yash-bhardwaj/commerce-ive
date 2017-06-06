// package com.rccl.cp.ive.get.myitinerary.api;
//
// import com.fasterxml.jackson.annotation.JsonCreator;
//
/// **
// * Type of the location in which a specific activity or product is offered
// */
// public enum LocationTypeENUM {
// PORT("PORT"),
// CITY("CITY"),
// SHIP_VENUE("SHIP_VENUE"),
// SHIP("SHIP");
//
// private String value;
//
// LocationTypeENUM(final String val) {
// this.value = val;
// }
//
// @Override
// public String toString() {
// return String.valueOf(value);
// }
//
// @JsonCreator
// public static LocationTypeENUM fromValue(final String text) {
// for (LocationTypeENUM b : LocationTypeENUM.values()) {
// if (String.valueOf(b.value).equals(text)) {
// return b;
// }
// }
// return null;
// }
// }
//
