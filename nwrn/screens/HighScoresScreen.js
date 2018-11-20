import React from 'react';
import {Alert, StyleSheet, Text, View, Button, NativeModules, Platform} from 'react-native';

export default class HighScoresScreen extends React.Component {

  static navigationOptions = {
    ...Platform.select({
      android: {
        header: null
      }
    }),
  };

  render() {

    const textForButton = Platform.select({
      ios: 'Display result in Swift >',
      android: 'Display result in Kotlin >'
    });

    console.log('this.props in HighScoresScreen', this.props);
    var contents = this.props.screenProps['scores'].map((score) => (
      <Text key={score.name}>
        {score.name}:{score.value}
        {'\n'}
      </Text>
    ));
    return (
      <View style={styles.container}>
        <Text style={styles.highScoresTitle}>High Scores:</Text>
        <Text style={styles.scores}>{contents}</Text>
        <Text style={styles.highScoresTitle}>(React Native Screen Made)</Text>
        <Button title={textForButton} onPress={() => {
          if (NativeModules.SideMenuExternalManager) {
            NativeModules.SideMenuExternalManager.showHighScoresResultFromJS(
              this.props.screenProps.scores.length)
          } else {
            Alert.alert(
              'Feature not available',
              'Only available for embeded app',
              [
                {text: 'OK', onPress: () => {}},
              ],
              { cancelable: false }
            )
          }
        }} />
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#FFFFFF',
  },
  highScoresTitle: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  scores: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});