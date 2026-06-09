import { useEffect, useState } from "react";

/**
 * DevNav Replayのトップ画面コンポーネント。
 */
function App() {
  const [message, setMessage] = useState<string>("読み込み中...");

  /**
   * Spring BootのHello APIからメッセージを取得する。
   */
  useEffect(() => {
    const fetchHello = async () => {
      const response = await fetch("http://localhost:8080/api/hello");
      const text = await response.text();
      setMessage(text);
    };

    fetchHello();
  }, []);

  return (
    <main style={{ padding: "40px", fontFamily: "sans-serif" }}>
      <h1>DevNav Replay</h1>
      <p>{message}</p>
    </main>
  );
}

export default App;
