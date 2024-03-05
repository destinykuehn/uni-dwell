namespace BCryptHasher
{
    class Hasher
    {
        /// <summary>
        /// Method that will hash a given string using BCrypt.Net HashPassword method
        /// </summary>
        /// <param name="msg"> The string to be hashed </param>
        /// <returns> The hash </returns>
        public static string Hash(string msg)
        {
            return BCrypt.Net.BCrypt.HashPassword(msg);
        }
        /// <summary>
        /// Method that will verify if a hash and a string are a corresponding pair
        /// </summary>
        /// <param name="hash"> The hash </param>
        /// <param name="msg"> The string </param>
        /// <returns> true if hash is the hash of msg, otherwise false </returns>
        public static bool Verify(string hash, string msg)
        {
            return BCrypt.Net.BCrypt.Verify(hash, msg);
        }
    }
}
