import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View} from 'react-native';

export default class SecondScreen extends Component {

    static navigationOptions = {
        title: 'Second Screen',
      };

    render() {
        return (
          <View style={styles.container}>
            <Text style={styles.welcome}>Second screen</Text>
            <Text style={styles.welcome}>(React Native Screen Made)</Text>
          </View>
        );
      }
}

const styles = StyleSheet.create({
    container: {
      flex: 1,
      justifyContent: 'center',
      alignItems: 'center',
      backgroundColor: '#F5FCFF',
    },
    welcome: {
      fontSize: 20,
      textAlign: 'center',
      margin: 10,
    },
  });